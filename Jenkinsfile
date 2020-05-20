pipeline {
   agent any
   tools {
      // Install the Maven version configured as "M3" and add it to the path.
      maven "Maven"
   }

   stages {
      stage('Build and run the tests') {
         steps {
            // Get some code from a GitHub repository
            git 'https://github.com/drozdovkostya/demoPactConsumerProject'

            // Run Maven on a Unix agent.
            sh "mvn clean package"

            // To run Maven on a Windows agent, use
            // bat "mvn -Dmaven.test.failure.ignore=true clean package"
         }

      }
      stage('Publish contract test to pact broker') {
          steps{
              sh "mvn verify pact:publish -DpactBrokerUrl=http://pact-broker -Drevision=$GIT_COMMIT"
            }

      }

//       stage('Can I deploy to TST') {
//           steps{
//                    sh(script:"curl --location --request GET 'http://pact-broker/can-i-deploy?pacticipant=test_provider&version=latestVersion&pacticipant=test_consumer&version=$GIT_COMMIT&to=tst' > reslut.out", returnStatus:true)
//                    script{def out = readFile 'reslut.out'
//                    println(out)
//                    if(!out.contains("All required verification results are published and successful")){
//                    currentBuild.result = 'FAILED'
//                    error('Contract test did not pass')
//                    }}
//             }
//       }
//       stage('Deploy to TST') {
//           steps{
//               sh "curl --location --request PUT 'http://pact-broker/pacticipants/test_consumer/versions/$GIT_COMMIT/tags/tst' --header 'Content-Type: application/json'"
//             }
//       }

//       stage('Can I deploy to ACC') {
//           steps{
//                    sh(script:"curl --location --request GET 'http://pact-broker/can-i-deploy?pacticipant=test_provider&version=latestVersion&pacticipant=test_consumer&version=$GIT_COMMIT&to=acc' > reslut.out", returnStatus:true)
//                    script{def out = readFile 'reslut.out'
//                    println(out)
//                    if(!out.contains("All required verification results are published and successful")){
//                    currentBuild.result = 'FAILED'
//                    error('Contract test did not pass')
//                    }}
//             }
//       }

//       stage('Deploy to ACC') {
//           steps{
//               sh "curl --location --request PUT 'http://pact-broker/pacticipants/test_consumer/versions/$GIT_COMMIT/tags/acc' --header 'Content-Type: application/json'"
//             }
//       }

//       stage('Can I deploy to PRD') {
//           steps{
//                    sh(script:"curl --location --request GET 'http://pact-broker/can-i-deploy?pacticipant=test_provider&version=latestVersion&pacticipant=test_consumer&version=$GIT_COMMIT&to=prd' > reslut.out", returnStatus:true)
//                    script{def out = readFile 'reslut.out'
//                    println(out)
//                    if(!out.contains("All required verification results are published and successful")){
//                    currentBuild.result = 'FAILED'
//                    error('Contract test did not pass')
//                    }}
//             }
//       }

//       stage('Deploy to PRD') {
//           steps{
//               sh "curl --location --request PUT 'http://pact-broker/pacticipants/test_consumer/versions/$GIT_COMMIT/tags/prd' --header 'Content-Type: application/json'"
//             }
//       }
   }


}
