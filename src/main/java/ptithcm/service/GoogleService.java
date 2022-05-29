package ptithcm.service;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collection;
@Service
public class GoogleService {
    @Autowired
   private GoogleCredential googleCredential;
   @Autowired
   ServletContext context;
    @Bean
    public Drive getService() throws GeneralSecurityException, IOException {
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        return new Drive.Builder(HTTP_TRANSPORT,
                JacksonFactory.getDefaultInstance(), googleCredential)
                .build();
    }
   @Bean
   public GoogleCredential googleCredential() throws GeneralSecurityException, IOException {
       Collection<String> elenco = new ArrayList<String>();
       elenco.add("https://www.googleapis.com/auth/drive");
       HttpTransport httpTransport = new NetHttpTransport();
       JacksonFactory jsonFactory = new JacksonFactory();
       return new GoogleCredential.Builder()
               .setTransport(httpTransport)
               .setJsonFactory(jsonFactory)
               .setServiceAccountId("cnpm-692@fluent-cosine-328613.iam.gserviceaccount.com")
               .setServiceAccountScopes(elenco)
               .setServiceAccountPrivateKeyFromP12File(new File("D:\\DOAN\\CNPM\\google_service.p12\\")).build();
   }

}
