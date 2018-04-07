node {
  stage('Operate') {
    echo "Operate Check is finished"
  }
   stage('Optimize') {
    echo "Optimize Check is finished"
  }
  stage('Secure') {
    echo "Secure Check is finished"
  }
  stage('Scale') {
    echo "Scale Check is finished"
  }
  stage('Summary') {
    echo "Summary is finished"
  }
}
