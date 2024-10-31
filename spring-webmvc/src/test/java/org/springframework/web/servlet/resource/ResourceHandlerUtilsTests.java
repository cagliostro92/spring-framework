package org.springframework.web.servlet.resource;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link ResourceHandlerUtils}.
 *
 * @author Edoardo Patti
 */
public class ResourceHandlerUtilsTests {

	@Test
	void testTrailingSlash() {
		var windowsDirectory = "META-INF\\resources\\webjars";
		var directory = "META-INF/resources/webjars";
		var directoryWithoutSlash = "META-INF";
		var correctWindowsDirectory = "META-INF\\resources\\webjars\\";
		var correctDirectory = "META-INF/resources/webjars/";
		assertThat(ResourceHandlerUtils.addTrailingSlashIfAbsent(windowsDirectory).endsWith("\\")).isTrue();
		assertThat(ResourceHandlerUtils.addTrailingSlashIfAbsent(directory).endsWith("/")).isTrue();
		assertThat(ResourceHandlerUtils.addTrailingSlashIfAbsent(directoryWithoutSlash).endsWith("/")).isTrue();
		assertThat(ResourceHandlerUtils.addTrailingSlashIfAbsent(correctWindowsDirectory)).isEqualTo(correctWindowsDirectory);
		assertThat(ResourceHandlerUtils.addTrailingSlashIfAbsent(correctDirectory)).isEqualTo(correctDirectory);
	}
}
