package nl.stgm.ql.interpreter.awtui;

import nl.stgm.ql.interpreter.*;

import java.util.Stack;
import java.awt.*;
import java.awt.event.*;

public class AWTUIController implements PagedUIController
{
	PagedUIDelegate delegate;
	
	AWTWindow window = new AWTWindow("Aangifteprogramma");
	AWTForm form;
	
	public AWTUIController(PagedUIDelegate delegate)
	{
		this.delegate = delegate;
	}
	
	public void show()
	{
		window.add(new AWTPrevNextPanel(delegate), BorderLayout.SOUTH);
		window.add(new AWTLogo(), BorderLayout.NORTH);
		window.setVisible(true);
	}
	
	public void clear()
	{
		if(form != null)
			window.remove(form);
	}

	public void validate()
	{
		window.pack();
	}
	
	public UIElementContainer getContainer()
	{
		return this.window;
	}

	public UIElementBool createCheckbox(String id, String label)
	{
		return new AWTCheckbox(delegate, id, label);
	}
	
	public UIElementText createTextField(String id, String label)
	{
		return new AWTTextField(delegate, id, label);
	}
	
	public UIElementLabel createLabel(String label)
	{
		return new AWTLabel(label);
	}
	
	public UIElementContainer createForm()
	{
		AWTForm elt = new AWTForm(delegate);
		this.form = elt;
		window.add(elt, BorderLayout.CENTER);
		return elt;
	}
	
	public UIElementConditional createConditional()
	{
		return new AWTConditional(delegate);
	}
}
