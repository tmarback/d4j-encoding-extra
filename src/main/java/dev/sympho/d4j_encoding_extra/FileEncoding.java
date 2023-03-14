package dev.sympho.d4j_encoding_extra;

import org.immutables.encode.Encoding;

import discord4j.core.spec.MessageCreateFields.File;

@Encoding
class FileEncoding {

    @Encoding.Impl
    private File field;

    @Encoding.Expose
    File get() {
        return field;
    }

    @Encoding.Copy
    @Encoding.Naming( standard = Encoding.StandardNaming.WITH )
    public File with( final File file ) {

        return of( file );

    }

    @Encoding.Of
    static File of( final File file ) {

        return File.of( file.name(), file.inputStream() );

    }

    @Encoding.Builder
    static class Builder {

        private File file;

        @Encoding.Init
        @Encoding.Copy
        @Encoding.Naming( standard = Encoding.StandardNaming.INIT )
        public void set( File file ) {
            this.file = file;
        }

        @Encoding.Build
        File build() {
            return this.file;
        }

    }
    
}
