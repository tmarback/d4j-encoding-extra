package dev.sympho.d4j_encoding_extra;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Enables all encodings provided by this package.
 */
@FileEncodingEnabled
@FileListEncodingEnabled
@FileSpoilerEncodingEnabled
@FileSpoilerListEncodingEnabled
@Target( { ElementType.PACKAGE, ElementType.TYPE } )
@Retention( RetentionPolicy.CLASS )
public @interface MetaExtraEncodingEnabled {}
