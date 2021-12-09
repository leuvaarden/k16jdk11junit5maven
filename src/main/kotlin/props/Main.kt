import org.apache.commons.cli.CommandLine
import org.apache.commons.cli.DefaultParser
import org.apache.commons.cli.HelpFormatter
import org.apache.commons.cli.Option
import org.apache.commons.cli.Options
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import kotlin.io.path.Path

private val commandLineParser = DefaultParser()
private val helpFormatter = HelpFormatter()
private const val syntax = "java -jar"
private const val header = "Encrypts properties or generates encryption key"
private const val footer = "Good luck!"

private val propertiesLocationOption = Option("i", true, "Properties location")
private val outputLocationOption = Option("o", true, "Output location (for properties or key)")
private val toEncryptOption = Option("e", true, "Comma separated property keys to encrypt")
private val keyLocationOption = Option("k", true, "Key location")

private val options = Options()
    .addOption(outputLocationOption)
    .addOption(propertiesLocationOption)
    .addOption(toEncryptOption)
    .addOption(keyLocationOption)

fun main(args: Array<String>) {
    val commandLine = commandLineParser.parse(options, args)
    if (canEncryptProperties(commandLine)) {
        encryptProperties(commandLine)
    } else if (canGenerateKey(commandLine)) {
        generateKey(commandLine)
    } else {
        helpFormatter.printHelp(syntax, header, options, footer, true)
    }
}

private fun canEncryptProperties(commandLine: CommandLine) =
    commandLine.hasOption(propertiesLocationOption)
            && commandLine.hasOption(keyLocationOption)
            && commandLine.hasOption(outputLocationOption)

private fun encryptProperties(commandLine: CommandLine) {
    val propertiesLocationString = commandLine.getOptionValue(propertiesLocationOption)
    val propertiesLocation = Path(propertiesLocationString)
    val propertiesLines = Files.readAllLines(propertiesLocation, StandardCharsets.UTF_8)

    val toEncryptString = commandLine.getOptionValue(toEncryptOption)
    val toEncrypt = toEncryptString?.split(',') ?: emptyList()

    val keyLocationString = commandLine.getOptionValue(keyLocationOption)
    val keyLocation = Path(keyLocationString)
    val keyBytes = Files.readAllBytes(keyLocation)

    val outputLocationString = commandLine.getOptionValue(outputLocationOption)
    val outputLocationPath = Path(outputLocationString)

    val encryptedProperties = PropertyEncryptor.encrypt(propertiesLines, toEncrypt, keyBytes)
    Files.write(outputLocationPath, encryptedProperties)
}

private fun canGenerateKey(commandLine: CommandLine) = commandLine.hasOption(outputLocationOption)

private fun generateKey(commandLine: CommandLine) {
    val outputLocationString = commandLine.getOptionValue(outputLocationOption)
    val outputLocationPath = Path(outputLocationString)
    val key = SecretKeyGenerator.generate()
    val keyBytes = key.encoded
    Files.write(outputLocationPath, keyBytes)
}