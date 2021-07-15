import java.util.Arrays;

public class ASN1toRSConverter {

	public static void main(String[] args) throws Exception {
		runAllTests();
	}
	
    public static void runAllTests() throws Exception {
        // 0221/0221
        // 3046022100e9015c081c3520c4415a9a61ea22abb06bb4787f927c6d9a4690c4d66ab35b11022100d3341aa2b54865c7751909aee62ac0cc598b02c235a5d09da0477e3e5fe1cd87
        // 3046 0221 00 e9015c081c3520c4415a9a61ea22abb06bb4787f927c6d9a4690c4d66ab35b11 0221 00 d3341aa2b54865c7751909aee62ac0cc598b02c235a5d09da0477e3e5fe1cd87
        // e9015c081c3520c4415a9a61ea22abb06bb4787f927c6d9a4690c4d66ab35b11d3341aa2b54865c7751909aee62ac0cc598b02c235a5d09da0477e3e5fe1cd87
        String referenceASN1_1 = "3046022100e9015c081c3520c4415a9a61ea22abb06bb4787f927c6d9a4690c4d66ab35b11022100d3341aa2b54865c7751909aee62ac0cc598b02c235a5d09da0477e3e5fe1cd87";
        String referenceRS_1 = "e9015c081c3520c4415a9a61ea22abb06bb4787f927c6d9a4690c4d66ab35b11d3341aa2b54865c7751909aee62ac0cc598b02c235a5d09da0477e3e5fe1cd87";
        test(referenceRS_1, referenceASN1_1);

        // 0221/0220
        // 3045022100b947b00152148a729e80347c728c788a3a85f058acb1ab23fdca13fd9dacc6d802202f8a6cd801b9ca361d306c3155c9bc9bd0174addcb29ad64949f767f1aa1e6a3
        // 3045 0221 00 b947b00152148a729e80347c728c788a3a85f058acb1ab23fdca13fd9dacc6d8 0220 2f8a6cd801b9ca361d306c3155c9bc9bd0174addcb29ad64949f767f1aa1e6a3
        // b947b00152148a729e80347c728c788a3a85f058acb1ab23fdca13fd9dacc6d82f8a6cd801b9ca361d306c3155c9bc9bd0174addcb29ad64949f767f1aa1e6a3
        String referenceASN1_2 = "3045022100b947b00152148a729e80347c728c788a3a85f058acb1ab23fdca13fd9dacc6d802202f8a6cd801b9ca361d306c3155c9bc9bd0174addcb29ad64949f767f1aa1e6a3";
        String referenceRS_2 = "b947b00152148a729e80347c728c788a3a85f058acb1ab23fdca13fd9dacc6d82f8a6cd801b9ca361d306c3155c9bc9bd0174addcb29ad64949f767f1aa1e6a3";
        test(referenceRS_2, referenceASN1_2);

        // 0220/0221
        // 3045022044f65884b2531de2c09cfe360a7aff87349989f4270a21570a1ace0c898602c0022100e26b69913454bf94c7cc5312fc071823f2d7837951bb82e9b157944ba15150b3
        // 3045 0220 44f65884b2531de2c09cfe360a7aff87349989f4270a21570a1ace0c898602c0 0221 00 e26b69913454bf94c7cc5312fc071823f2d7837951bb82e9b157944ba15150b3
        // 44f65884b2531de2c09cfe360a7aff87349989f4270a21570a1ace0c898602c0e26b69913454bf94c7cc5312fc071823f2d7837951bb82e9b157944ba15150b3
        String referenceASN1_3 = "3045022044f65884b2531de2c09cfe360a7aff87349989f4270a21570a1ace0c898602c0022100e26b69913454bf94c7cc5312fc071823f2d7837951bb82e9b157944ba15150b3";
        String referenceRS_3 = "44f65884b2531de2c09cfe360a7aff87349989f4270a21570a1ace0c898602c0e26b69913454bf94c7cc5312fc071823f2d7837951bb82e9b157944ba15150b3";
        test(referenceRS_3, referenceASN1_3);

        // 0220/0220
        // 3044022046083ba46a9cabd6897638241ceafa7466b0acd0d7713ffaa8b4fd741547bcfa022067168b0fc7e8ed1d53b3b53f2f3c8ca75cb1e66b456bbe63296d2a97dbf8a7d9
        // 3044 0220 46083ba46a9cabd6897638241ceafa7466b0acd0d7713ffaa8b4fd741547bcfa 0220 67168b0fc7e8ed1d53b3b53f2f3c8ca75cb1e66b456bbe63296d2a97dbf8a7d9
        // 46083ba46a9cabd6897638241ceafa7466b0acd0d7713ffaa8b4fd741547bcfa67168b0fc7e8ed1d53b3b53f2f3c8ca75cb1e66b456bbe63296d2a97dbf8a7d9
        String referenceASN1_4 = "3044022046083ba46a9cabd6897638241ceafa7466b0acd0d7713ffaa8b4fd741547bcfa022067168b0fc7e8ed1d53b3b53f2f3c8ca75cb1e66b456bbe63296d2a97dbf8a7d9";
        String referenceRS_4 = "46083ba46a9cabd6897638241ceafa7466b0acd0d7713ffaa8b4fd741547bcfa67168b0fc7e8ed1d53b3b53f2f3c8ca75cb1e66b456bbe63296d2a97dbf8a7d9";
        test(referenceRS_4, referenceASN1_4);

        // 021f/0220
        // 3043021f31d0565e6e7085f2d8675bae5c68fdc7ecfe5514489f132eaa70e10ddce875022025135629e9341d1930bb7af5de0343f8732203755eb66b129d027bf787ad7f9f
        // 3043 021f 31d0565e6e7085f2d8675bae5c68fdc7ecfe5514489f132eaa70e10ddce875 0220 25135629e9341d1930bb7af5de0343f8732203755eb66b129d027bf787ad7f9f
        // 0031d0565e6e7085f2d8675bae5c68fdc7ecfe5514489f132eaa70e10ddce87525135629e9341d1930bb7af5de0343f8732203755eb66b129d027bf787ad7f9f
        String referenceASN1_5 = "3043021f31d0565e6e7085f2d8675bae5c68fdc7ecfe5514489f132eaa70e10ddce875022025135629e9341d1930bb7af5de0343f8732203755eb66b129d027bf787ad7f9f";
        String referenceRS_5 = "0031d0565e6e7085f2d8675bae5c68fdc7ecfe5514489f132eaa70e10ddce87525135629e9341d1930bb7af5de0343f8732203755eb66b129d027bf787ad7f9f";
        test(referenceRS_5, referenceASN1_5);

        // 0220/021f
        // 304302201131d0565e6e7085f2d8675bae5c68fdc7ecfe5514489f132eaa70e10ddce875021f135629e9341d1930bb7af5de0343f8732203755eb66b129d027bf787ad7f9f
        // 3043 0220 1131d0565e6e7085f2d8675bae5c68fdc7ecfe5514489f132eaa70e10ddce875 021f 135629e9341d1930bb7af5de0343f8732203755eb66b129d027bf787ad7f9f
        // 1131d0565e6e7085f2d8675bae5c68fdc7ecfe5514489f132eaa70e10ddce87500135629e9341d1930bb7af5de0343f8732203755eb66b129d027bf787ad7f9f
        String referenceASN1_6 = "304302201131d0565e6e7085f2d8675bae5c68fdc7ecfe5514489f132eaa70e10ddce875021f135629e9341d1930bb7af5de0343f8732203755eb66b129d027bf787ad7f9f";
        String referenceRS_6 = "1131d0565e6e7085f2d8675bae5c68fdc7ecfe5514489f132eaa70e10ddce87500135629e9341d1930bb7af5de0343f8732203755eb66b129d027bf787ad7f9f";
        test(referenceRS_6, referenceASN1_6);

        // 021f/021f
        // 3042021f31d0565e6e7085f2d8675bae5c68fdc7ecfe5514489f132eaa70e10ddce875021f135629e9341d1930bb7af5de0343f8732203755eb66b129d027bf787ad7f9f
        // 3042 021f 31d0565e6e7085f2d8675bae5c68fdc7ecfe5514489f132eaa70e10ddce875 021f 135629e9341d1930bb7af5de0343f8732203755eb66b129d027bf787ad7f9f
        // 0031d0565e6e7085f2d8675bae5c68fdc7ecfe5514489f132eaa70e10ddce87500135629e9341d1930bb7af5de0343f8732203755eb66b129d027bf787ad7f9f
        String referenceASN1_7 = "3042021f31d0565e6e7085f2d8675bae5c68fdc7ecfe5514489f132eaa70e10ddce875021f135629e9341d1930bb7af5de0343f8732203755eb66b129d027bf787ad7f9f";
        String referenceRS_7 = "0031d0565e6e7085f2d8675bae5c68fdc7ecfe5514489f132eaa70e10ddce87500135629e9341d1930bb7af5de0343f8732203755eb66b129d027bf787ad7f9f";
        test(referenceRS_7, referenceASN1_7);

        // 0201/0202
        // 300702015502025657
        // 3007 0201 55 0202 5657
        // 00000000000000000000000000000000000000000000000000000000000000550000000000000000000000000000000000000000000000000000000000005657
        String referenceASN1_8 = "300702015502025657";
        String referenceRS_8 = "00000000000000000000000000000000000000000000000000000000000000550000000000000000000000000000000000000000000000000000000000005657";
        test(referenceRS_8, referenceASN1_8);
    }

    public static void test(String signatureRShex, String signatureASN1hex) throws Exception {
        byte[] signatureRS = hexStringToByteArray(signatureRShex);
        byte[] signatureASN1 = hexStringToByteArray(signatureASN1hex);

        byte[] signatureRS_convert = convertFromASN1toRS(signatureASN1, 32);
        System.out.println(signatureRShex);
        System.out.println(bytesToHex(signatureRS_convert).toLowerCase());
        System.out.println();
        if (!Arrays.equals(signatureRS, signatureRS_convert)) {
        	throw new Exception("Failed...");
        };
    }

    public static byte[] convertFromASN1toRS(byte[] signatureASN1, int size) {
        // Get start and length
        int sequenceR = 2;
        int lengthR = signatureASN1[sequenceR + 1];
        int startR = sequenceR + 2;

        int sequenceS = sequenceR + lengthR + 2;
        int lengthS = signatureASN1[sequenceS + 1];
        int startS = sequenceS + 2;

        // Get offset
        int srcOffsetR = startR;
        int countR = size;
        int dstOffsetR = 0;
        if (lengthR > size)
        {
            srcOffsetR += lengthR - size;
        }
        else if (lengthR < size)
        {
            dstOffsetR += size - lengthR;
            countR -= dstOffsetR;
        }

        int srcOffsetS = startS;
        int countS = size;
        int dstOffsetS = 0;
        if (lengthS > size)
        {
            srcOffsetS += lengthS - size;
        }
        else if (lengthS < size)
        {
            dstOffsetS += size - lengthS;
            countS -= dstOffsetS;
        }

        // Concatenate
        byte[] rs = new byte[2 * size];
        System.arraycopy(signatureASN1, srcOffsetR, rs, dstOffsetR, countR);
        System.arraycopy(signatureASN1, srcOffsetS, rs, dstOffsetR + countR + dstOffsetS, countS);

        return rs;
    }

    // from SO: https://stackoverflow.com/a/140861
    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                 + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
    
    // from SO: https://stackoverflow.com/a/9855338
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }
}
