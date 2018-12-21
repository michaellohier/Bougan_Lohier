% % Boucle pour la 4eme partie

% Tmax = (90:30:150);
% LENGTH_TRIP = (1800:200:2200);
% FVAL = [];
% for tmax = Tmax
%     Ligne_FVAL = [];
%     for length_trip = LENGTH_TRIP



%Definition des parametres pour la 2eme partie

dt = 1;
tmax = 120;
Temps = (0:dt:tmax)';
length_trip = 2000;

% %Initialisation 1

% Dist0 = (length_trip/tmax)*Temps;

%Initialisation 2

lim1 = tmax/3 +1;
lim2 = 2 * (tmax/3) +1;
length_vect = length(Temps);

Dist0 = linspace(0,length_trip,length_vect)';
Dist0(1:lim1) = (1.3/2)*Temps(1:lim1).*Temps(1:lim1) ;
p = -0.366 * tmax +3 * (length_trip/tmax);
q = 0.072 * tmax*tmax - (p * tmax/3);
Dist0(lim1+1:lim2) = p *Temps(lim1+1:lim2)+q;
Dist0(lim2:length_vect) = -0.45*Temps(lim2:length_vect).*Temps(lim2:length_vect)+0.9*tmax*Temps(lim2:length_vect)+length_trip-0.45*tmax*tmax;

Vit0 = [0; diff(Dist0)/dt];
Gamma0 = [0; diff(Vit0)/dt];
VarGamma0 = [0; diff(Gamma0)/dt];

% %affichage de la situation initiale

X0 = Dist0;
X0 = [X0; Vit0];
X0 = [X0; Gamma0];
X0 = [X0; VarGamma0];

% figure("Name"," Trajet initial")
% plot(Temps,Dist0,'r')   
% grid
% 
% figure("Name"," Vitesse initiale")
% plot(Temps, Vit0, 'b')
% grid

%Definition des contraintes d'inegalite

    % x(i+1) >= x(i)
 
A = [];
for i = 1:length_vect-1
    A = [A; zeros(1,i-1) 1 -1 zeros(1,length_vect-2 - (i-1))];  
end
A = [A zeros(length_vect-1, 3*length_vect )];
b = zeros(length_vect-1,1);

    % Pour t = 0:1 minutes x(i)<2000

for i = 1:(length_vect-1)/2
    A = [A; zeros(1,i-1) 1 zeros(1,(length_vect-1)/2-(i-1)) zeros(1, (length_vect-1)/2) zeros(1, 3* length_vect)];
end
    b = [b; (length_trip-1) * ones((length_vect-1)/2,1)];

%Contraintes d'egalite

Aeq = [1 zeros(1,4*length_vect-1)];
Aeq = [Aeq; zeros(1,length_vect-1) 1 zeros(1,3*length_vect)];
Aeq = [Aeq; zeros(1,length_vect) 1 zeros(1,3*length_vect-1)];
Aeq = [Aeq; zeros(1,2*length_vect-1) 1 zeros(1,2*length_vect)];

beq = [0; length_trip; 0; 0];


%Definition des limites inférieues et supérieures

lb = zeros(2*length_vect,1);
lb = [lb; -0.9* ones(1*length_vect,1)];
lb = [lb; -0.022* ones(1*length_vect,1)];

ub = length_trip * ones(length_vect,1);
ub = [ub; (140/3.6)*ones(length_vect,1)];
ub = [ub; 1.3*ones(length_vect,1)];
ub = [ub; 0.022*ones(length_vect,1)];


% fonction de minimilisation

[X,fval] = fmincon(@fun,X0,A,b,Aeq,beq,lb,ub,@mycon);

% %Affichage du résultat

figure("Name"," Trajet")
plot(Temps,X(1:length_vect,1),'r')   
grid

figure("Name"," Vitesse ")
plot(Temps,X(length_vect+1:2*length_vect,1), 'b')
grid


% %Ajout au tableau FVAL

%     Ligne_FVAL = [Ligne_FVAL fval];
%     
%     end
%     
%     FVAL = [FVAL; Ligne_FVAL];
% end



