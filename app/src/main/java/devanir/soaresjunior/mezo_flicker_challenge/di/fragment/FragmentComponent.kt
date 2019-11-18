package devanir.soaresjunior.mezo_flicker_challenge.di.fragment

import dagger.Subcomponent
import devanir.soaresjunior.mezo_flicker_challenge.ui.photolist.PhotoListFragment
import devanir.soaresjunior.mezo_flicker_challenge.ui.photoinfo.PhotosInfoFragment

@FragmentScope
@Subcomponent(modules = [FragmentModule::class])
interface FragmentComponent {
    fun inject(photosListFragment: PhotoListFragment)
    fun inject(photosInfoFragment: PhotosInfoFragment)
}
