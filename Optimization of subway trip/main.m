%Definition des parametres

dt = 1;
tmax = 120;
Temps = (0:dt:tmax)';
length_trip = 2000;

%Initialisation 1

%Dist0 = (length_trip/tmax)*Temps;

%Initialisation 2

lim1 = 39;
lim2 = 90;
length_vect = length(Temps);
Dist0 = linspace(0,length_trip,length_vect)';
Dist0(1:lim1) = (1.3/2)*Temps(1:lim1).*Temps(1:lim1) ;
Dist0(lim1+1:lim2) = 11.6 *Temps(lim1+1:lim2)+545;
Dist0(lim2+1:length_vect) = -0.45*Temps(lim2+1:length_vect).*Temps(lim2+1:length_vect)+108*Temps(lim2+1:length_vect)-4480;
Vit0 = [0; diff(Dist0)/dt];
Gamma0 = [0; diff(Vit0)/dt];
VarGamma0 = [0; diff(Gamma0)/dt];

%affichage de la situation initiale

X0 = Dist0;
X0 = [X0; Vit0];
X0 = [X0; Gamma0];
X0 = [X0; VarGamma0];

figure("Name"," Trajet initial")
plot(Temps,Dist0,'r')   
grid

figure("Name"," Vitesse initiale")
plot(Temps, Vit0, 'b')
grid

%Definition des contraintes d'inegalite

    % x(i+1) >= x(i)
 
A = [];
for i = 1:length_vect-1
    A = [A; zeros(1,i-1) 1 -1 zeros(1,length_vect-2 - (i-1))];  
end
A = [A zeros(length_vect-1, 3*length_vect )];
b = zeros(length_vect-1,1);

    % Pour t = 0:1.5 minutes x(i)<2000

for i = 1:3*(length_vect-1)/4
    A = [A; zeros(1,i-1) 1 zeros(1,((3*(length_vect-1))/4)-(i-1)) zeros(1, (length_vect-1)/4) zeros(1, 3* length_vect)];
end
    b = [b; (2000-1) * ones(3*(length_vect-1)/4,1)];

%Contraintes d'egalite

Aeq = [1 zeros(1,4*length_vect-1)];
Aeq = [Aeq; zeros(1,length_vect-1) 1 zeros(1,3*length_vect)];
Aeq = [Aeq; zeros(1,length_vect) 1 zeros(1,3*length_vect-1)];
Aeq = [Aeq; zeros(1,2*length_vect-1) 1 zeros(1,2*length_vect)];

beq = [0; 2000; 0; 0];


%Definition des limites inférieues et supérieures

lb = zeros(2*length_vect,1);
lb = [lb; -0.9* ones(1*length_vect,1)];
lb = [lb; -0.22* ones(1*length_vect,1)];

ub = 2000 * ones(length_vect,1);
ub = [ub; (140/3.6)*ones(length_vect,1)];
ub = [ub; 1.3*ones(length_vect,1)];
ub = [ub; 0.22*ones(length_vect,1)];


% fonction de minimilisation

[X,fval] = fmincon(@fun,X0,A,b,Aeq,beq,lb,ub,@mycon);

%Affichage du résultat

figure("Name"," Trajet")
plot(Temps,X(1:length_vect,1),'r')   
grid

figure("Name"," Vitesse ")
plot(Temps,X(length_vect+1:2*length_vect,1), 'b')
grid
    





