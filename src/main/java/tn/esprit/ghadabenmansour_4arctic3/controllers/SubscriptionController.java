package tn.esprit.ghadabenmansour_4arctic3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ghadabenmansour_4arctic3.entities.Subscription;
import tn.esprit.ghadabenmansour_4arctic3.services.SubscriptionServices;

import java.util.List;

@RestController
@RequestMapping("subscription")
public class SubscriptionController {

    @Autowired
    @Qualifier("subscriptionServices")
    private SubscriptionServices subscriptionServices;

    @PostMapping("add")
    public Subscription addSubscription(@RequestBody Subscription subscription) {
        return subscriptionServices.addSubscription(subscription);
    }

    @PutMapping("update")
    public Subscription updateSubscription(@RequestBody Subscription subscription) {
        return subscriptionServices.updateSubscription(subscription);
    }

    @GetMapping("retrieve/{numSub}")
    public ResponseEntity<Subscription> retrieveSubscription(@PathVariable Long numSub) {
        Subscription subscription = subscriptionServices.retrieveSubscription(numSub);
        if (subscription == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(subscription);
    }

    @GetMapping("retrieveAll")
    public List<Subscription> retrieveAllSubscriptions() {
        return subscriptionServices.retrieveAllSubscriptions();
    }

    @DeleteMapping("remove/{numSub}")
    public void removeSubscription(@PathVariable Long numSub) {
        subscriptionServices.removeSubscription(numSub);
    }
}
