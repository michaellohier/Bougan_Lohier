function integrale = fun(X)
dt = 0.1;
Dist = X(1: length(X)/4);
Vit = [0; diff(Dist)/dt];
Gamma = [0; diff(Vit)/dt];
VarGamma = [0; diff(Gamma)/dt];
fonctionAIntegrer = Gamma .* Vit;
integrale = trapz(fonctionAIntegrer);
end

