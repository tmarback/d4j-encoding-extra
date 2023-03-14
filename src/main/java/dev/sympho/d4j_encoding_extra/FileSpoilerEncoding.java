package dev.sympho.d4j_encoding_extra;

import org.immutables.encode.Encoding;

import discord4j.core.spec.MessageCreateFields.FileSpoiler;

@Encoding
class FileSpoilerEncoding {

    @Encoding.Impl
    private FileSpoiler field;

    @Encoding.Expose
    FileSpoiler get() {
        return field;
    }

    @Encoding.Copy
    @Encoding.Naming( standard = Encoding.StandardNaming.WITH )
    public FileSpoiler with( final FileSpoiler file ) {

        return of( file );

    }

    @Encoding.Of
    static FileSpoiler of( final FileSpoiler file ) {

        return FileSpoiler.of( file.name(), file.inputStream() );

    }

    @Encoding.Builder
    static class Builder {

        private FileSpoiler file;

        @Encoding.Init
        @Encoding.Copy
        @Encoding.Naming( standard = Encoding.StandardNaming.INIT )
        public void set( FileSpoiler file ) {
            this.file = file;
        }

        @Encoding.Build
        FileSpoiler build() {
            return this.file;
        }

    }
    
}
