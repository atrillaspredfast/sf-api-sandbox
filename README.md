# sf-api-sandbox
Spredfast Public API SandBox

What is the Sandbox?
The goal of Sandbox is to simplify the development of Spredfast Conversation Public API consumers. It is a web application with Swagger UI code embedding.
Swagger UI consumes Sandbox endpoints (because of Same Origin Policy, Swagger UI can't access API Server or other server from different origin)
which call API Server endpoints to get the Swagger definition (/swagger.json).
To allow Spredfast API Server and Sandbox interactions, API Server needs to be changed. Using Swagger core and annotations technologies,
new endpoint (swagger.json) is added and existing endpoints are completed with Swagger Annotations.


For more details about Swagger and Swagger Annotations you can read :
 * http://swagger.io/getting-started/
 * https://github.com/swagger-api/swagger-core/wiki/Annotations-1.5.X


For more details about Swager UI security policy you can read:
 * https://en.wikipedia.org/wiki/Same-origin_policy


How to run the Sandbox:
  * Change to Sandbox source directory:
    cd <SANDBOX_HOME>
  * Execute bootRun task:
    ./gradlew bootRun

