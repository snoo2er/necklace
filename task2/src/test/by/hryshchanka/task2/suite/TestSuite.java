package test.by.hryshchanka.task2.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.by.hryshchanka.task2.action.GemCreatorTest;
import test.by.hryshchanka.task2.action.NecklaceActionTest;
import test.by.hryshchanka.task2.parser.GemParserTest;
import test.by.hryshchanka.task2.parser.NecklaceParseTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({GemParserTest.class, NecklaceParseTest.class, 
	GemCreatorTest.class, NecklaceActionTest.class})
public class TestSuite {
	
}


