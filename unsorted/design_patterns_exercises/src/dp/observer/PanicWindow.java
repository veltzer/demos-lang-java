package dp.observer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

public class PanicWindow extends Frame
{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Label messageLabel;
	private Panel flashPanel;

	public PanicWindow()
	{
		super("Panic attack!");
	}

	public void init()
	{
		setLayout(new BorderLayout());
		messageLabel = new Label();
		add(messageLabel, BorderLayout.SOUTH);

		flashPanel = new Panel();
		flashPanel.setBackground(Color.WHITE);
		add(flashPanel, BorderLayout.CENTER);

		addWindowListener(new WindowAdapter()
		{
			/* (non-Javadoc)
			 * @see java.awt.event.WindowAdapter#windowClosed(java.awt.event.WindowEvent)
			 */
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		setSize(400, 400);
		setVisible(true);
	}

	public void setPanicGenerator(Observable panicGenerator)
	{
		panicGenerator.addObserver(new Observer()
		{
			public void update(Observable o, Object arg)
			{
				messageLabel.setText((String) arg);
			}
		});
		panicGenerator.addObserver(new Observer()
		{
			public void update(Observable o, Object arg)
			{
				redFlash();
			}
		});
	}

	private void redFlash()
	{
		flashPanel.setBackground(Color.RED);
		TimerTask clearTask = new TimerTask()
		{
			public void run()
			{
				flashPanel.setBackground(Color.WHITE);
			}
		};
		Timer timer = new Timer();
		timer.schedule(clearTask, 200);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		PanicWindow window = new PanicWindow();
		window.init();
		PanicAttack attack = new PanicAttack();
		window.setPanicGenerator(attack);
	}

}
