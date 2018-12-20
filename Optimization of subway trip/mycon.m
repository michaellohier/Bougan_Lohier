function [C,Ceq] = mycon(X)
length_vect = length(X)/4;


%Contraintes sur la vitesse
for i = 1:length_vect
    if X(i)>=0 && X(i)<=500
       C(length_vect+i)=X(length_vect+i)-140/3;6;
    elseif X(i)>=0 && X(i)<=500
       C(length_vect+i)=X(length_vect+i)-120/3;6; 
    elseif X(i)>=0 && X(i)<=500
       C(length_vect+i)=X(length_vect+i)-100/3;6; 
    elseif X(i)>=0 && X(i)<=500
       C(length_vect+i)=X(length_vect+i)-120/3;6;
    elseif X(i)>=0 && X(i)<=500
       C(length_vect+i)=X(length_vect+i)-140/3;6; 
    end  
Ceq(1) = X(1);
Ceq(2) = X(length_vect);


end

