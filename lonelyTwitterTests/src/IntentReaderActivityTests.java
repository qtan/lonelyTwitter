import org.w3c.dom.Text;

import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;
import ca.ualberta.cs.lonelytwitter.R;



public class IntentReaderActivityTests extends
		ActivityInstrumentationTestCase2<IntentReaderActivity>
{

	public IntentReaderActivityTests()
	{

		super(IntentReaderActivity.class);
	}

	protected void setUp() throws Exception
	{

		super.setUp();
	}
	
	public void testSendText(){
		String text = "hello world!";
		IntentReaderActivity activity = startWithText(text, IntentReaderActivity.NORMAL);
		assertEquals("got the text?",text,activity.getText());
		
	}
	
	public void testDoubleText()
	{
		String text = "hello world!";
		IntentReaderActivity activity = startWithText(text,IntentReaderActivity.DOUBLE);
		assertEquals("double text?",text+text, activity.getText());
		
		
	}
	
	public void testDisplayText()
	{
		String text = "hello";
		IntentReaderActivity activity = startWithText(text, IntentReaderActivity.NORMAL);
		TextView view =(TextView) activity.findViewById(R.id.intentText);
		assertEquals("correct text?",text ,view.getText());
		
	}
	
	
	
	private IntentReaderActivity startWithText(String text,int mode)
	{
		Intent intent = new Intent();
		intent.putExtra(IntentReaderActivity.TEXT_KEY,text);
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, mode);
		setActivityIntent(intent);
		return (IntentReaderActivity) getActivity();
		
	}
}
