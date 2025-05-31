package test;

import observer.Observable;
import observer.Observer;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class ObserverTest {

    @Test
    public void testNotifyAll() {
        Observable observable = new Observable();
        Observer mockObserver = mock(Observer.class);
        observable.subscribe(mockObserver);
        observable.notifyAll("evento");
        verify(mockObserver, times(1)).update("evento");
    }
}
