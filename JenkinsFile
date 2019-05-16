Pipeline{
agent any
tools {
	maven 'apache-maven-3.6.0' 
}
Stages{
Stage('clone source code from the repository'){
Steps{
echo'cloning';
}
}
Stage('compileing the souce code'){
Steps{
mvn clean compile;
}
}
Stage('Packaging  the Souxce code'){
Steps{
mvn clean install;
}
}
Stage('Deploying the source code'){
Steps{
echo'Deploying';
}
}
}
}

