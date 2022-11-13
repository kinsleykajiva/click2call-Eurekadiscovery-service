package zihub.org.eurekadiscovery;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
/**
 * Called by Eureka when the service instance is unregistered (/cancelled)
 */
@Component
@RequiredArgsConstructor
public class EurekaInstanceCanceledListener {

  //  private final GatewayNotifier gatewayNotifier;

    /**
     * Translates service instance Eureka metadata from older versions to the current version
     */
    @EventListener
    @HystrixCommand
    public void listen(EurekaInstanceCanceledEvent event) {
        System.out.println("EurekaInstanceCanceledListener.listen()::1::" +event.getServerId());
        System.out.println("EurekaInstanceCanceledListener.listen():2::" +event.getAppName());
       // gatewayNotifier.serviceCancelledRegistration(EurekaUtils.getServiceIdFromInstanceId(event.getServerId()));
    }

}
