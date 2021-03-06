package com.plexobject.quran.metrics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MetricTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected = IllegalArgumentException.class)
	public final void testGetMetricWithNull() {
		Metric.getMetric(null);
	}

	@Test
	public final void testGetMetric() {
		final Metric metric = Metric.getMetric("metric");
		Assert.assertNotNull(metric);
	}

	@Test
	public final void testNewTimer() throws InterruptedException {
		final Metric metric = new Metric("test");

		final Timer timer = metric.newTimer();
		Thread.sleep(10);
		timer.stop();

		Assert.assertEquals(1, metric.getTotalCalls());
		Assert.assertTrue(metric.getAverageDurationInMilliSecs() > 0);
		Assert.assertTrue(metric.getTotalDurationInMilliSecs() > 0);

	}
}
