package zihub.org.eurekadiscovery;


import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.util.EurekaUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Map;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
@Component
@RequiredArgsConstructor
public class EurekaInstanceRegisteredListener {

  /*  private final MetadataTranslationService metadataTranslationService;
    private final MetadataDefaultsService metadataDefaultsService;
    private final GatewayNotifier gatewayNotifier;*/

    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event) {
        System.out.println("EurekaInstanceRegisteredEvent:::1::" +event.getInstanceInfo().getAppName());
        System.out.println("EurekaInstanceRegisteredEvent::::2::" +event.getInstanceInfo().getInstanceId());
        final InstanceInfo instanceInfo = event.getInstanceInfo();
        final Map<String, String> metadata = instanceInfo.getMetadata();
      //  final String serviceId = EurekaUtils.getServiceIdFromInstanceId(instanceInfo.getInstanceId());

     //   metadataTranslationService.translateMetadata(serviceId, metadata);
     //   metadataDefaultsService.updateMetadata(serviceId, metadata);

      //  if (StringUtils.equalsIgnoreCase(GatewayNotifier.GATEWAY_SERVICE_ID, serviceId)) {
            /**
             * meanwhile gateway was down, another Gateway could receive logout, those invalidated credentials should
             * be distributed to this new Gateway
             */
          //  gatewayNotifier.distributeInvalidatedCredentials(instanceInfo.getInstanceId());
        //}
        // ie. new instance can have different authentication (than other one), this is reason to evict caches on gateway
       // gatewayNotifier.serviceUpdated(serviceId, instanceInfo.getInstanceId());
    }



}
