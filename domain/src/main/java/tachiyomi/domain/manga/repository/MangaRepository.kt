package tachiyomi.domain.manga.repository

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import tachiyomi.core.rx.RxOptional
import tachiyomi.domain.manga.model.Manga
import tachiyomi.domain.source.model.SManga

interface MangaRepository {

  fun setFlags(manga: Manga, flags: Int): Completable

  fun getManga(mangaId: Long): Flowable<RxOptional<Manga>>

  fun getManga(key: String, sourceId: Long): Flowable<RxOptional<Manga>>

  fun saveAndReturnNewManga(manga: SManga, sourceId: Long): Single<Manga>

  fun deleteNonFavorite(): Completable
}