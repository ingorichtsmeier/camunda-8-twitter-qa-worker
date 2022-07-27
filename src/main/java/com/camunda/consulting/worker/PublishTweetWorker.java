package com.camunda.consulting.worker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.client.api.worker.JobHandler;
import io.camunda.zeebe.spring.client.annotation.ZeebeWorker;

@Component
public class PublishTweetWorker implements JobHandler {
  
  private static final Logger LOG = LoggerFactory.getLogger(PublishTweetWorker.class);

  @ZeebeWorker(type = "tweetPublishing")
  public void handle(JobClient client, ActivatedJob job) throws Exception {
    LOG.info("Publish something");
    
    client.newCompleteCommand(job).send().join();
  }

}
