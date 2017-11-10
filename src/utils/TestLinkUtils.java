package utils;
import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;

public class TestLinkUtils {
    // Replace Testlink API Interface access key here
    public final static String ACCESS_KEY = "API AQUI";
 
    // Replace your TestLink Server URL here
    public final static String TESTLINK_SERVER_URL = "http://linkaqui.com.br/testlink/lib/api/xmlrpc/v1/xmlrpc.php";
 
    // Replace Project Name here
    public final static String TESTLINK_PROJECT_NAME = "Grupo3";
 
    // Replace your Test Plan here
    public final static String TESTLINK_TESTPLAN_NAME = "GerenciadorPampatec";
 
    // Replace your Build Name here
    public final static String BUILD_RELEASE_NAME = "Autenticacao";
    
    public static void reportResult(String testCaseID, String executionNotes, String result) throws TestLinkAPIException {
        TestLinkAPIClient apiClient = new TestLinkAPIClient(ACCESS_KEY,TESTLINK_SERVER_URL);
        apiClient.reportTestCaseResult(TESTLINK_PROJECT_NAME, TESTLINK_TESTPLAN_NAME,testCaseID, BUILD_RELEASE_NAME, executionNotes, result);
   }
}