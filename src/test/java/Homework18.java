import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {
 @Test
    public void playSong() throws InterruptedException {

  provideEmail("valeriya.trygubova@testpro.io");
  providePassword("ltZaqmXZ");
  clickSubmit();
  Thread.sleep(2000);

  playNextSong();
  clickPlay();

  //Assert
  Assert.assertTrue(isSongPlaying());

 }

     public boolean isSongPlaying() {
     WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
     return soundBar.isDisplayed();
  }


}
