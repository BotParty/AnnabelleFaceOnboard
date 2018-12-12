package org.botparty.annabelle;

import org.botparty.annabelle.command.CommandGenerator;
import org.botparty.annabelle.parser.ChatParser;

import org.junit.Ignore;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ParserTest {



    private void runTest(String test, List<String[]> expectedResult) throws Throwable {
        CommandGenerator actualMock = mock(CommandGenerator.class);
        ArgumentCaptor<String> verbCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String[]> parmCaptor = ArgumentCaptor.forClass(String[].class);

        ChatParser parser = new ChatParser(actualMock);

        parser.parse(test);

        verify(actualMock,times(expectedResult.size())).generate(verbCaptor.capture(),parmCaptor.capture());

        List<String> totalParms = new ArrayList<>();
        int i = 0;
        for(String[] result: expectedResult) {
            assertEquals(result[0], verbCaptor.getAllValues().get(i++));
            if (result.length > 1) {
                totalParms.addAll(Arrays.asList(Arrays.copyOfRange(result, 1, result.length)));
            }
        }
        assertArrayEquals(totalParms.toArray(),parmCaptor.getAllValues().toArray());
    }

    @Test
    public void emptyString() throws Throwable {
        runTest("",new ArrayList<String[]>(){{}});
    }

    @Test
    public void singleCommandNoParm() throws Throwable {
        runTest("\\scream",Arrays.asList( new String[][] {{"scream"}}));
    }

    @Test
    public void singleCommand1Parm() throws Throwable {
        runTest("\\say thing",Arrays.asList( new String[][] {{"say","thing"}}));
    }

    @Test
    public void singleCommand2Parm() throws Throwable {

        runTest("\\run something now",
                 Arrays.asList( new String[][] {{"run","something","now"}}));
    }

    @Test
    public void textOnly() throws Throwable {
        runTest("Hello World",Arrays.asList( new String[][] {{"say", "Hello World"}}));
    }

    @Test
    public void textthenCommand() throws Throwable {
        runTest("Hello World \\face wink",Arrays.asList( new String[][] {
                                                {"say", "Hello World"},
                                                {"face","wink"}}));
    }

    @Test
    public void commandThenText() throws Throwable {
        runTest("\\face smile Hello World",Arrays.asList( new String[][] {
                                                {"face", "smile"},
                                                {"say", "Hello World"}}));
    }

    @Test
    public void textAroundCommand() throws Throwable {
        runTest("Hello \\pause 2 World",Arrays.asList( new String[][] {
                                                {"say", "Hello"},
                                                {"pause", "2"},
                                                {"say", "World"}}));
    }

    @Test(expected = org.antlr.v4.runtime.RecognitionException.class)
    @Ignore
    public void badCommand() throws Throwable {
        runTest("\\invalidCommand1245",Arrays.asList( new String[][] {
                {"invalidCommand1245"}}));
    }

    @Test(expected =org.antlr.v4.runtime.NoViableAltException.class)
    @Ignore
    public void badCommandMissingParms() throws Throwable {
        runTest("\\run athing",Arrays.asList( new String[][] {
                {"run","athing"}}));
    }
}