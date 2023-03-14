package dev.sympho.d4j_encoding_extra;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.google.common.collect.ImmutableList;

import org.immutables.encode.Encoding;

import discord4j.core.spec.MessageCreateFields.FileSpoiler;

@Encoding
class FileSpoilerListEncoding {

    @Encoding.Impl
    private ImmutableList<FileSpoiler> field = ImmutableList.of();

    private static FileSpoiler copy( final FileSpoiler file ) {
        return FileSpoiler.of( file.name(), file.inputStream() );
    }

    @Encoding.Expose
    List<FileSpoiler> getList() {
        return field;
    }

    @Encoding.Expose
    ImmutableList<FileSpoiler> getImmutableList() {
        return field;
    }

    @Encoding.Copy
    @Encoding.Naming( standard = Encoding.StandardNaming.WITH )
    ImmutableList<FileSpoiler> withCollectionVarargs( FileSpoiler... elements ) {

        final ImmutableList.Builder<FileSpoiler> fs = ImmutableList.builder();
        for ( final var f : elements ) {
            fs.add( copy( f ) );
        }
        return fs.build();

    }

    @Encoding.Copy
    @Encoding.Naming( standard = Encoding.StandardNaming.WITH )
    ImmutableList<FileSpoiler> withCollection( Iterable<? extends FileSpoiler> elements ) {

        final ImmutableList.Builder<FileSpoiler> fs = ImmutableList.builder();
        for ( final var f : elements ) {
            fs.add( copy( f ) );
        }
        return fs.build();

    }

    @Encoding.Of
    public static ImmutableList<FileSpoiler> of( Collection<? extends FileSpoiler> input ) {

        final ImmutableList.Builder<FileSpoiler> fs = ImmutableList.builder();
        input.stream().map( f -> copy( f ) ).forEach( fs::add );
        return fs.build();

    }

    @Encoding.Builder
    static class Builder {

        private ImmutableList.Builder<FileSpoiler> list = ImmutableList.builder();

        @Encoding.Init
        @Encoding.Copy
        @Encoding.Naming( standard = Encoding.StandardNaming.INIT )
        void setIterable( final Iterable<? extends FileSpoiler> files ) {

            this.list = ImmutableList.builder();
            files.forEach( f -> list.add( copy( f ) ) );

        }

        @Encoding.Naming( standard = Encoding.StandardNaming.ADD )
        @Encoding.Init
        void add( final FileSpoiler... files ) {
            Arrays.asList( files ).forEach( f -> list.add( copy( f ) ) );
        }

        @Encoding.Naming( standard = Encoding.StandardNaming.ADD_ALL )
        @Encoding.Init
        void addAll( final Iterable<? extends FileSpoiler> files ) {
            files.forEach( f -> list.add( copy( f ) ) );
        }

        @Encoding.Build
        ImmutableList<FileSpoiler> build() {
            return list.build();
        }

    }
    
}
