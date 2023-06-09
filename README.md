# java14

Collections -> Factory Method of: creates an immutable data structure.
```
// Before
List<String> names = new ArrayList<>();
names.add( "Jardel" );
names.add( "Kuhn" );
List<String> unmodifiableNames = Collections.unmodifiableList( names );
  
// After
List<String> immutableNames = List.of( "Jardel", "Kuhn" );
// immutableNames.add( "other" ); -> throws Exception

Set.of( "My", "Name" );

Map<Integer, String> immutableMap = Map.of( 1, "A", 2, "B", 3, "C" );
```

LocalVariable Type-Inference: can be used in method context and local variables only.
```
public class Test {

  // var someString = "here it doesn't works";

  private String prcoess() { return "result"; }

  public static void main(String[] args){
  
    // Recommended situations to use
    var message = "Hello, Java 10"; // message -> string
    var oneMap = new HashMap<Integer, String>(); // correct
    
    // Unrecommended situations
    var result = obj.prcoess(); // result type is not clear
    var x = emp.getProjects.stream().findFirst().map(String::length).orElse(0); // streams
    var oneMap = new HashMap<>(); // map type will be <Object, Object>
    
    // Error situations
    // var n;
    // var emptyList = null;
    // var inLambda = ( String s ) -> s.length() > 10;
  }

}
```

Text Block:
```
String longText = """
  one really long text one really long text
  one really long text one really long text
  one really long text one really long text
  one really long text one really long text
  """;
```

Switch Expression:
```
String nome = "Jardel";
switch (nome){
  case "Jardel" -> System.out.println( "Acertou o nome" );
  case "Kuhn" -> System.out.println( "Acertou o sobrenome" );
  default -> System.out.println( "Errou" );
}
```

HTTP/2 Client API
```
public class Teste{
  
  public static void main(String[] args) throws Exception {
    HttpClient httpClient = new HttpClient.newHttpClient();
    HttpRequest httpRequest = HttpRequest.newBuilder( new URI("https://casadocodigo.com.br") ).GET().build();
    
    // Blocking request
    HttpResponse<String> response = httpClient.send( httpRequest, BodyHandlers.ofString() );
    
    System.out.println( response.statusCode() );
    System.out.println( response.body() );
    System.out.println( response.version() );
    
    // Async request
    httpClient.sendAsync( httpRequest, BodyHandlers.ofString() ) // sendAsync returns a CompletableFuture<HttpResponse<String>>
              .whenComplete( ( success, throwable ) -> System.out.println( success.body() ) );
  }

}
```
