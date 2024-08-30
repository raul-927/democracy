<p><h3>INICIAR VAULT</h3></p>
Desde consola, ejecutar el siguiente comando:

vault server --dev --dev-root-token-id="00000000-0000-0000-0000-000000000000" </br></br>
<b>ir a la carpeta raiz del proyecto ServiceConfiguration, abrir una consola y ejecutar los siguientes comandos:</b>

vault kv put secret/accountancy @Accountancy-dev.json

vault kv put secret/human-resources @HumanResources-dev.json

vault kv put secret/products @Products-dev.json

<p><h3>INICIAR KEYCLOAK</h3></p>
Ir al directorio donde se encuentran los archivos keycloak, abrir una terminal,
y ejecutar el siguiente comando:

bin/kc.sh start-dev --http-port=8181

<p><h3>Ejecutar los micro servicios en el siguiente orden:</h3></p>

<li>1- ConfigServer</li>
<li>2-DiscoveryServer</li>
<li>3-ApiGateway</li>
<li>4-Microservices (Estos no importa el orden)</li>
<li>5-En la barra superior donde aparece el nombre del microservicio que se está ejecutando, desplegar e ir a edit configuration/modify options/ Add VM options</li>
<li>6- agregar la siguiente linea: -Djava.library.path="/home/raul927/DESAROLLO/bin"</li>


