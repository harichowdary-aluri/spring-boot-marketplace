package com.marketplace.Helpers.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;


@Configuration
public class AWSSNSConfig {
	 // Value is populated with the aws access key.
    @Value("${aws.access_key_id}")
    private String awsAccessKey;
 
    // Value is populated with the aws secret key
    @Value("${aws.secret_access_key}")
    private String awsSecretKey;
 
    // Value is populated with the aws region code
    @Value("${cloud.aws.region.static}")
    private String region;
	@Bean
	public AmazonSNS amazonSNS() {
		return (AmazonSNSClient) AmazonSNSClientBuilder
                .standard()
                .withRegion(region)
                .withCredentials(new AWSStaticCredentialsProvider(
                        new BasicAWSCredentials(awsAccessKey, awsSecretKey)))
                .build();

}
}

