package nl.stgm.ql.ast.form;

public class Question extends FormItem
{
	private String id;
	private String question;
	private String type;
	
	public Question(String id, String question, String type)
	{
		this.id = id;
		this.question = question;
		this.type = type;
	}
	
	public String toString()
	{
		return("Question " + question);
	}
}
