package nl.stgm.ql.parser.rats;

import java.io.IOException;
import java.io.StringReader;

import nl.stgm.ql.ast.Expr;
import nl.stgm.ql.parser.test.IParse;
import nl.stgm.ql.parser.test.ParseError;

import xtc.parser.Result;

public class RatsParser implements IParse
{
	public RatsParser()
	{
	}

	@Override public Expr parse(String src) throws ParseError
	{
		QLParser parser = new QLParser(new StringReader(src), "-");

		try
		{
			Result result = parser.pParseForm(0);
			if (result.hasValue())
			{
				return result.semanticValue();
			}
			throw new ParseError(result.parseError().msg);
		}
		catch (IOException e)
		{
			return null;
		}
	}
}
