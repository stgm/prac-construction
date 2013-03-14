package nl.stgm.ql.ast.form;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.inspectors.*;

import java.util.List;

public class Conditional extends FormItem
{
	private Expr condition;
	private List<Question> ifQuestions;
	private List<Question> elseQuestions;
	
	public Conditional(Expr condition, List<Question> ifQuestions, List<Question> elseQuestions)
	{
		this.condition = condition;
		this.ifQuestions = ifQuestions;
		this.elseQuestions = elseQuestions;
	}

	public void print(PrettyPrinter context)
	{
		context.print("if(");
		condition.print(context);
		context.println(") {");
				
		context.increaseIndent();
		for (Question q: ifQuestions)
			q.print(context);
		context.decreaseIndent();
		context.println("}");

		if(elseQuestions != null)
		{
			context.println("else {");
			context.increaseIndent();
			for (Question q: elseQuestions)
			{
				q.print(context);
			}
			context.decreaseIndent();
			context.println("}");
		}

	}
}
