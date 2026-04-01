import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CalculatorTest {
    @Mock
    Adder adder;
    @InjectMocks
    Calculator calculator;

    @BeforeEach
    void setUp() {
        doAnswer(invoc->{
            int a = invoc.getArgument(0);
            int b = invoc.getArgument(1);
            return a+b;
        }).when(adder).add(anyInt(), anyInt());
    }

    @Test
    void add() {
        int result = calculator.add(1, 2);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void subtract() {
        int result = calculator.subtract(41, 23);
        assertThat(result).isEqualTo(18);
    }

    @Test
    void multiply() {
        int result = calculator.multiply(3, -4);
        assertThat(result).isEqualTo(-12);
    }

    @Test
    void divide() {
        int result = calculator.divide(6, 2);
        assertThat(result).isEqualTo(3);
    }
}