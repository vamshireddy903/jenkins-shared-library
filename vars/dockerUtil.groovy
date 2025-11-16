def dockerImageBuild(String imageName) {
    echo "Image is building..."
    sh """
      docker build -t ${imageName} .
    """   
}