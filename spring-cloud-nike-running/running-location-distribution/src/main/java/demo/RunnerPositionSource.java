package demo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@EnableBinding(Source.class)
public class RunnerPositionSource {

    @Autowired
    private MessageChannel output;


    @RequestMapping(params = "/api/locations", method = RequestMethod.POST)
    public void locations(@RequestBody String positionInfo) {
        log.info("Receiving current PositionInfo from Simulator: " + positionInfo);
        this.output.send(org.springframework.messaging.support.MessageBuilder.withPayload(positionInfo).build());
    }

}
