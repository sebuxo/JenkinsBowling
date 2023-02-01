import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class BowlingTest {

    private BowlingGame game;


    void rollMany(int n,int pins,BowlingGame game) { for(int i = 0; i <n ; i++) game.roll(pins);}

    @Before
    public void Setup(){
        this.game= new BowlingGame();
    }
    @Test
    public void rollZero(){
        rollMany(20,0,game);
        assertEquals(0,game.score());
    }

    @Test
    public void testSpare(){
        game.roll(7);
        game.roll(3);
        game.roll(3);
      assertEquals(16, game.score());
    }

    @Test
    public void testStrike(){
        game.roll(10);
        game.roll(3);
        game.roll(3);
        assertEquals(22,game.score());
    }

    @Test
    public void testPerfectGame(){
        rollMany(12,10,game);
        assertEquals(300,game.score());
    }

    @Test
    public void testOnePinPerThrow(){
        rollMany(12,1,game);
        assertEquals(12, game.score());

    }





}
