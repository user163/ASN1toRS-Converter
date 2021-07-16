# ASN1toRS-Converter
Converts an ECDSA signature in ASN.1/DER format (RFC 3279) to rs (IEEE P1363) format. For a definition of the ASN.1/DER format s. the accepted answer of this SO post: 

https://crypto.stackexchange.com/questions/1795/how-can-i-convert-a-der-ecdsa-signature-to-asn-1

The conversion is done with `public static byte[] ConvertFromASN1toRS(byte[] signatureASN1, int size)`. Here `signatureASN1` is the byte array containing the signature in ASN.1/DER format and `size` is the key size (e.g. 32 bytes for P-256 aka prime256v1 aka secp256r1).

Note: C# supports the rs format and as of .NET 5.0 the ASN.1/DER format. BouncyCastle supports (in later versions) both formats (e.g. `SHA1withECDSA` and `SHA1withPlainECDSA`).
