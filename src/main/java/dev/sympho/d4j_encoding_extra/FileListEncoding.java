package dev.sympho.d4j_encoding_extra;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.google.common.collect.ImmutableList;

import org.immutables.encode.Encoding;

import discord4j.core.spec.MessageCreateFields.File;

@Encoding
class FileListEncoding {

    @Encoding.Impl
    private ImmutableList<File> field = ImmutableList.of();

    private static File copy( final File file ) {
        return File.of( file.name(), file.inputStream() );
    }

    @Encoding.Expose
    List<File> getList() {
        return field;
    }

    @Encoding.Expose
    ImmutableList<File> getImmutableList() {
        return field;
    }

    @Encoding.Copy
    @Encoding.Naming( standard = Encoding.StandardNaming.WITH )
    ImmutableList<File> withCollectionVarargs( File... elements ) {

        final ImmutableList.Builder<File> fs = ImmutableList.builder();
        for ( final var f : elements ) {
            fs.add( copy( f ) );
        }
        return fs.build();

    }

    @Encoding.Copy
    @Encoding.Naming( standard = Encoding.StandardNaming.WITH )
    ImmutableList<File> withCollection( Iterable<? extends File> elements ) {

        final ImmutableList.Builder<File> fs = ImmutableList.builder();
        for ( final var f : elements ) {
            fs.add( copy( f ) );
        }
        return fs.build();

    }

    @Encoding.Of
    public static ImmutableList<File> of( Collection<? extends File> input ) {

        final ImmutableList.Builder<File> fs = ImmutableList.builder();
        input.stream().map( f -> copy( f ) ).forEach( fs::add );
        return fs.build();

    }

    @Encoding.Builder
    static class Builder {

        private ImmutableList.Builder<File> list = ImmutableList.builder();

        @Encoding.Init
        @Encoding.Copy
        @Encoding.Naming( standard = Encoding.StandardNaming.INIT )
        void setIterable( final Iterable<? extends File> files ) {

            this.list = ImmutableList.builder();
            files.forEach( f -> list.add( copy( f ) ) );

        }

        @Encoding.Naming( standard = Encoding.StandardNaming.ADD )
        @Encoding.Init
        void add( final File... files ) {
            Arrays.asList( files ).forEach( f -> list.add( copy( f ) ) );
        }

        @Encoding.Naming( standard = Encoding.StandardNaming.ADD_ALL )
        @Encoding.Init
        void addAll( final Iterable<? extends File> files ) {
            files.forEach( f -> list.add( copy( f ) ) );
        }

        @Encoding.Build
        ImmutableList<File> build() {
            return list.build();
        }

    }
    
}
