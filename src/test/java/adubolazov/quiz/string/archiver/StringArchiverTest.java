package adubolazov.quiz.string.archiver;

import static adubolazov.quiz.string.archiver.StringArchiver.archive;
import static org.junit.Assert.*;

import org.junit.Test;

public class StringArchiverTest {

	@Test
	public void testArchive() {
		assertNull(archive(null));
		assertEquals("", archive(""));
		assertEquals("AA111222333", archive("AA111222333"));
		assertEquals("2 ", archive("  "));
		assertEquals("5A", archive("AAAAA"));
		assertEquals("5A3BC", archive("AAAAABBBC"));
		assertEquals("ABC", archive("ABC"));
		assertEquals("A5BC", archive("ABBBBBC"));
	}
}
