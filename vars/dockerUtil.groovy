def dockerImageBuild(String imageName) {
    echo "Image is building..."
    sh """
      docker build -t ${imageName} .
    """   
}

def deployContainer(String imageName, String portMapping ="8083:8081") {
    echo "Image is building..."
    sh """
      docker run -d -p ${portMapping} ${imageName} 
    """   
}