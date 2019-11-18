package devanir.soaresjunior.mezo_flicker_challenge.di.app

import dagger.Component
import devanir.soaresjunior.mezo_flicker_challenge.di.fragment.FragmentComponent
import devanir.soaresjunior.mezo_flicker_challenge.di.fragment.FragmentModule
import devanir.soaresjunior.mezo_flicker_challenge.di.network.NetworkModule

@AppScope
@Component(modules = [NetworkModule::class, AppModule::class])
interface AppComponent {
    fun newFragmentComponent(fragmentModule: FragmentModule): FragmentComponent
}
