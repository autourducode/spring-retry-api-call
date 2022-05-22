package io.autourducode.retryapicall;

import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rickenbazolo
 */
@RestController
@RequestMapping("/site-web")
public class DemoController {

    @GetMapping("/{nom}")
    @Retryable(value = RuntimeException.class, maxAttempts = 4, backoff = @Backoff(value = 4000L))
    public ResponseEntity<String> getSiteWeb(@PathVariable String nom) {
        System.out.println("==== getSiteWeb ====");
        if (nom.equals("autourducode")) {
            return ResponseEntity.ok().body("Site Web: "+nom);
        }
        throw new RuntimeException();
    }

    @Recover
    public ResponseEntity<String> recuperer(@PathVariable String nom) {
        System.out.println("==== recuperer ====");
        System.out.println("API non disponible!");
        return ResponseEntity.ok().body("API non disponible!");
    }
}
