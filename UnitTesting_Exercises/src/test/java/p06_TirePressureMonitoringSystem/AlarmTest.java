package p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class AlarmTest {
    private Sensor sensor;
    private Alarm alarm;

    @Before
    public void init(){
        sensor = Mockito.mock(Sensor.class);
        alarm = new Alarm(sensor);
    }

    @Test
    public void testCheckMethodWithPressureInRange(){
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(17.0);
        Assert.assertFalse(alarm.getAlarmOn());
    }

    @Test
    public void testCheckMethodWithHigherPressure(){
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(22.0);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testCheckMethodWithLowerPressure(){
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(16.0);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }
}