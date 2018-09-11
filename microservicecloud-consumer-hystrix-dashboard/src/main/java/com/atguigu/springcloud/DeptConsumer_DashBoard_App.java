package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class DeptConsumer_DashBoard_App {
	
	public static void main(String[] args) {
		SpringApplication.run(DeptConsumer_DashBoard_App.class, args);
	}
	
	/**
	 * 启动报错：注释掉  热部署插件就OK，查询说明：jar包冲突所致
	 * Exception in thread "main" java.lang.IllegalStateException: Failed to read Class-Path attribute from manifest of jar file:/D:/server/repository/org/webjars/jquery/2.1.1/jquery-2.1.1.jar
				at org.springframework.boot.devtools.restart.ChangeableUrls.getUrlsFromClassPathOfJarManifestIfPossible(ChangeableUrls.java:110)
				at org.springframework.boot.devtools.restart.ChangeableUrls.fromUrlClassLoader(ChangeableUrls.java:96)
				at org.springframework.boot.devtools.restart.DefaultRestartInitializer.getUrls(DefaultRestartInitializer.java:93)
				at org.springframework.boot.devtools.restart.DefaultRestartInitializer.getInitialUrls(DefaultRestartInitializer.java:56)
				at org.springframework.boot.devtools.restart.Restarter.<init>(Restarter.java:140)
				at org.springframework.boot.devtools.restart.Restarter.initialize(Restarter.java:546)
				at org.springframework.boot.devtools.restart.RestartApplicationListener.onApplicationStartingEvent(RestartApplicationListener.java:67)
				at org.springframework.boot.devtools.restart.RestartApplicationListener.onApplicationEvent(RestartApplicationListener.java:45)
				at org.springframework.context.event.SimpleApplicationEventMulticaster.doInvokeListener(SimpleApplicationEventMulticaster.java:172)
				at org.springframework.context.event.SimpleApplicationEventMulticaster.invokeListener(SimpleApplicationEventMulticaster.java:165)
				at org.springframework.context.event.SimpleApplicationEventMulticaster.multicastEvent(SimpleApplicationEventMulticaster.java:139)
				at org.springframework.context.event.SimpleApplicationEventMulticaster.multicastEvent(SimpleApplicationEventMulticaster.java:122)
				at org.springframework.boot.context.event.EventPublishingRunListener.starting(EventPublishingRunListener.java:69)
				at org.springframework.boot.SpringApplicationRunListeners.starting(SpringApplicationRunListeners.java:48)
				at org.springframework.boot.SpringApplication.run(SpringApplication.java:292)
				at org.springframework.boot.SpringApplication.run(SpringApplication.java:1118)
				at org.springframework.boot.SpringApplication.run(SpringApplication.java:1107)
				at com.atguigu.springcloud.DeptConsumer_DashBoard_App.main(DeptConsumer_DashBoard_App.java:12)
			Caused by: java.util.zip.ZipException: invalid LOC header (bad signature)
				at java.util.zip.ZipFile.read(Native Method)
				at java.util.zip.ZipFile.access$1400(ZipFile.java:60)
				at java.util.zip.ZipFile$ZipFileInputStream.read(ZipFile.java:734)
				at java.util.zip.ZipFile$ZipFileInflaterInputStream.fill(ZipFile.java:434)
				at java.util.zip.InflaterInputStream.read(InflaterInputStream.java:158)
				at sun.misc.IOUtils.readFully(IOUtils.java:65)
				at java.util.jar.JarFile.getBytes(JarFile.java:425)
				at java.util.jar.JarFile.getManifestFromReference(JarFile.java:193)
				at java.util.jar.JarFile.getManifest(JarFile.java:180)
				at org.springframework.boot.devtools.restart.ChangeableUrls.getUrlsFromManifestClassPathAttribute(ChangeableUrls.java:131)
				at org.springframework.boot.devtools.restart.ChangeableUrls.getUrlsFromClassPathOfJarManifestIfPossible(ChangeableUrls.java:107)
				... 17 more

	 *  
	 */
}
