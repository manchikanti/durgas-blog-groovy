package scripts.filehash

import java.security.DigestInputStream
import java.security.MessageDigest
import java.security.Security

/**
 * Utility to get hash of file content
 */
def generateHash(File file, String algorithm = 'sha-256') {
    file.withInputStream {
        new DigestInputStream(it, MessageDigest.getInstance(algorithm)).withStream {
            it.eachByte {}
            it.messageDigest.digest().encodeHex() as String
        }
    }
}
File file = new File('manchikanti.png')
String fileHash = generateHash(file)
//Got following hash on Groovy Version: 2.4.7 JVM: 1.8.0_73 Vendor: Oracle Corporation OS: Mac OS X
//Expecting this to be same ever for given file
assert fileHash == '7121acf3cd7001beba7c90ddb2551f6c5a4901e301ebdbc2e14a8e2be366b7a2'
println 'All is well!!'