package tn.esprit.ghadabenmansour_4arctic3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.ghadabenmansour_4arctic3.entities.Subscription;
import tn.esprit.ghadabenmansour_4arctic3.entities.TypeSubscription;
import tn.esprit.ghadabenmansour_4arctic3.repositories.ISubscriptionRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Service
public class SubscriptionServices implements ISubscriptionServices {

    @Autowired
    private ISubscriptionRepository subscriptionRepository;

    @Override
    public Subscription addSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public Subscription updateSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public Subscription retrieveSubscription(Long numSub) {
        return subscriptionRepository.findById(numSub).orElse(null);
    }

    @Override
    public List<Subscription> retrieveAllSubscriptions() {
        return (List<Subscription>) subscriptionRepository.findAll();
    }

    @Override
    public void removeSubscription(Long numSub) {
        subscriptionRepository.deleteById(numSub);
    }
    @Override
    public Set<Subscription> getSubscriptionByType(TypeSubscription type) {
        return new TreeSet<>(subscriptionRepository.findByTypeSubscriptionOrderByStartDate(type));
    }
    @Override
    public List<Subscription> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate) {
        return subscriptionRepository.findByStartDateBetween(startDate, endDate);
    }
}
