//
//  ContentView.swift
//  StuffFriendsSay
//
//  Created by Mike Gehard on 3/10/20.
//  Copyright © 2020 Mike Gehard. All rights reserved.
//

import SwiftUI
import greetings
import goodbyes

struct ContentView: View {
    var body: some View {
        Text("\(GreetingsKt.hello())\n\n\(GoodbyesKt.goodbye())")
        
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
