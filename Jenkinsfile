pipeline{
agent any
tools {
	maven 'apache-maven-3.6.0' 
}
stages{
stage('clone source code from the repository'){
steps{
echo'cloning';
}
}
stage('compileing the souce code'){
steps{
mvn clean compile;
}
}
stage('Packaging  the Souxce code'){
steps{
mvn clean install;
}
}
stage('Deploying the source code'){
steps{
	mvn clean deploy
echo'Deploying';
}
}
}
}

