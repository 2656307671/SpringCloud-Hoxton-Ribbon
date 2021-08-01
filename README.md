在cloud-consumer-order80这个服务消费者模块中，com.szh.myrule这个包下是Ribbon的核心组件IRule的定义配置信息；
同时在主启动类上添加：@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration=MySelfRule.class)；
之后可以依次启动7001、7002、8001、8002、80，到浏览器中测试：localhost/consumer/payment/get/1，即可实现在com.szh.myrule这个包下定义的随机访问8001、8002。

手写轮询算法：分别在8001、8002的controller中做修改，添加@GetMapping(value = "/payment/lb")这个请求；
 在80中的ApplicationContextConfig类中，注释掉@LoadBalanced这个注解，因为我们要手写自己的轮询算法，就不能再用之前的了；
 然后自定义接口、实现类，在com.szh.springcloud.lb包下，在80的controller中做修改，添加@GetMapping("/consumer/payment/lb")这个请求；
 最后依次启动7001、7002、8001、8002、80，到浏览器中测试：localhost/consumer/payment/lb，即可看到8001、8002交替出现。
